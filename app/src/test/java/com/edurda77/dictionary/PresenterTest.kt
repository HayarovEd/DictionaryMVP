package com.edurda77.dictionary

import android.content.Context
import com.edurda77.dictionary.model.data.WordTranslate
import com.edurda77.dictionary.model.datasource.CaseRepoImpl
import com.edurda77.dictionary.presenter.Presenter
import com.edurda77.dictionary.view.BaseMainActivity
import com.nhaarman.mockito_kotlin.atLeast
import com.nhaarman.mockito_kotlin.never
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
    @Mock
    private lateinit var context: Context
    @Mock
    private lateinit var activity: BaseMainActivity
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = Presenter(caseRepoImpl, context)
    }
    @Test
    fun search_Test() {
        val searchQuery = "кот"
        presenter.getData(searchQuery)
        //presenter.getData(searchQuery)
        verify(caseRepoImpl, times(1)).getData(searchQuery)
    }


}