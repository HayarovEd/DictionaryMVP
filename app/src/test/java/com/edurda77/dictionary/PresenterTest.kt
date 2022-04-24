package com.edurda77.dictionary

import com.edurda77.dictionary.model.datasource.CaseRepoImpl
import com.edurda77.dictionary.presenter.Presenter
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class PresenterTest {

    private lateinit var presenter: Presenter
    @Mock
    private lateinit var caseRepoImpl: CaseRepoImpl
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = Presenter(caseRepoImpl)
    }
    @Test
    fun search_Test() {
        val searchQuery = "кот"
        presenter.getData("кот")
        verify(caseRepoImpl, times(1)).getData(searchQuery)
    }

}