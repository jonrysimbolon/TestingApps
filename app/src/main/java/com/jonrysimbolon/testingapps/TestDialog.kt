package com.jonrysimbolon.testingapps

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface

class TestDialog(): DialogInterface {
    override fun cancel() {
        TODO("Not yet implemented")
    }

    override fun dismiss() {
        TODO("Not yet implemented")
    }
}

class TestDialog2(context: Context): Dialog(context){

}