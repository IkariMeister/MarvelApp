package com.ikarimeister.marvelapp.domain

import com.ikarimeister.marvelapp.data.Repository
import com.ikarimeister.marvelapp.domain.model.Hero
import javax.inject.Inject

class GetAllHeroes @Inject constructor(private val repository: Repository<Hero,String>) {

    suspend operator fun invoke() : List<Hero> = repository.getAll()
}