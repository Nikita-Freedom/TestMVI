package com.example.testmvi.intent

sealed class MainIntent
{
    object FetchUser : MainIntent()
}