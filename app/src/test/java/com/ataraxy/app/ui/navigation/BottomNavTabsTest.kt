package com.ataraxy.app.ui.navigation

import org.junit.Assert.assertEquals
import org.junit.Test

class BottomNavTabsTest {

    @Test
    fun highlightedTab_tappedFromSubScreen_returnsToItsRoot() {
        assertEquals(TabClick.ReturnToRoot, tabClickAction(Screen.Practices.route, Screen.BookendRitual.route))
    }

    @Test
    fun practiceTab_tappedWhileOnQuotePractice_returnsToItsRoot() {
        assertEquals(TabClick.ReturnToRoot, tabClickAction(Screen.Practice.BASE, Screen.Practice.ROUTE))
    }

    @Test
    fun tabTapped_onItsOwnRoot_doesNothing() {
        assertEquals(TabClick.Ignore, tabClickAction(Screen.Practices.route, Screen.Practices.route))
    }

    @Test
    fun otherTab_navigates() {
        assertEquals(TabClick.Navigate, tabClickAction(Screen.Archive.route, Screen.BookendRitual.route))
    }
}
