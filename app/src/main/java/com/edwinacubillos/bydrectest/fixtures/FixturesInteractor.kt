package com.edwinacubillos.bydrectest.fixtures

import com.edwinacubillos.bydrectest.model.fixtures.Fixtures

class FixturesInteractor : FixturesContract.Interactor {

    private var presenter: FixturesContract.Presenter
    private var repository: IFixturesRepository

    constructor(presenter: FixturesContract.Presenter) {
        this.presenter = presenter
        repository = FixturesRepository(this)
    }

    override fun loadFixtures() {
        repository.loadFixtures()
    }

    override fun fixturesLoaded(listFixtures: List<Fixtures>?) {
        presenter.fixturesLoaded(listFixtures)
    }
}
