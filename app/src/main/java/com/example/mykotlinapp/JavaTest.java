package com.example.mykotlinapp;

import android.util.Log;

public class JavaTest {
    void add() {
        Log.e("TAG", "add: ");
    }
}

class TewTest extends JavaTest {

    void add() {
        super.add();
    }
}
