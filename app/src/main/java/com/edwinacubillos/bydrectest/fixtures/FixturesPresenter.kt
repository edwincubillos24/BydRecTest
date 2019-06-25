package com.edwinacubillos.bydrectest.fixtures

import com.edwinacubillos.bydrectest.model.fixtures.Fixtures

class FixturesPresenter : FixturesContract.Presenter {

    private var view: FixturesContract.View
    private var interactor: FixturesContract.Interactor

    constructor(view: FixturesContract.View) {
        this.view = view
        interactor = FixturesInteractor(this)
    }

    override fun loadFixtures() {
        interactor.loadFixtures()
    }

    override fun fixturesLoaded(listFixtures: List<Fixtures>?) {
        view.showFixtures(listFixtures)
    }
}
