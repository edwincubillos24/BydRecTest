package com.edwinacubillos.bydrectest.fixtures

import com.edwinacubillos.bydrectest.model.fixtures.Fixtures

interface FixturesContract {
    interface View {
        fun showFixtures(listFixtures: List<Fixtures>?)
    }

    interface Presenter {
        fun loadFixtures()
        fun fixturesLoaded(listFixtures: List<Fixtures>?)
    }

    interface Interactor {
        fun loadFixtures()
        fun fixturesLoaded(listFixtures: List<Fixtures>?)
    }
}
