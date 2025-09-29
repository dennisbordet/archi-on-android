package fr.univ.nantes.data.login.di

import fr.univ.nantes.data.login.LoginUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val loginModule = module {
    factoryOf(::LoginUseCase)
}