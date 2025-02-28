package kw.team.common.di

import javax.inject.Qualifier

@Qualifier
@Retention
annotation class Gpt

@Qualifier
@Retention
annotation class Claude

@Qualifier
@Retention
annotation class Dispatcher(val dispatcher: DispatcherType)

enum class DispatcherType {
    IO,
}
