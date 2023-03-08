package com.phone.phonegui;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;

public class LoadingTest {

    @Test
    public void testCreateLoadingScreen()
    {
        Loading loading = new Loading();
        assertSame(1, 1);
    }

}
