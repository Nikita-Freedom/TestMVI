package com.example.testmvi.intent

import com.example.testmvi.viewstate.MainState
import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.Observable

interface UserView : MvpView{
    fun searchIntent(): Observable<String>

    fun render(mainState: MainState?) // Берет выход от model(MainState)(наше неизменное обновленное состояние)

}