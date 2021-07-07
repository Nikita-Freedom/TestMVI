package com.example.testmvi.viewmodel.util

import com.example.testmvi.data.api.ApiHelperImpl
import com.example.testmvi.data.api.RetrofitBuilder
import com.example.testmvi.data.repository.MainRepository
import com.example.testmvi.intent.GetUserInteractor
import com.example.testmvi.intent.UserView
import com.example.testmvi.viewstate.MainState
import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

class UserPresenter : MviBasePresenter<UserView, MainState>() {
    private val searchInteractor: GetUserInteractor =
        GetUserInteractor(MainRepository(ApiHelperImpl(apiService = RetrofitBuilder.getRetrofit())))

    override fun bindIntents() {
        val search: Observable<MainState> = intent(UserView::searchIntent)
            .switchMap(searchInteractor::getUser) // I have used flatMap() in the video above, but switchMap() makes more sense here
            .observeOn(AndroidSchedulers.mainThread())
        subscribeViewState(search, UserView::render)
    }
}