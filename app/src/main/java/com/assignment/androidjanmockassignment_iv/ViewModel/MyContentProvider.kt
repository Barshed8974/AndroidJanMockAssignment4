package com.assignment.androidjanmockassignment_iv.ViewModel


import android.content.Context
import android.content.CursorLoader
import android.provider.ContactsContract
import com.assignment.androidjanmockassignment_iv.ModelClasses.MyModel

class MyContentProvider(val context: Context) {
    fun fetchall(): ArrayList<MyModel> {
        val fields = arrayOf(
            ContactsContract.Profile.NAME_RAW_CONTACT_ID,
            ContactsContract.Profile.DISPLAY_NAME_PRIMARY,
        )
        val listSms = ArrayList<MyModel>()

        val curLoader = CursorLoader(
            context,
            ContactsContract.Contacts.CONTENT_URI,
            fields,
            null,
            null,
            null
        )
        val cursor = curLoader.loadInBackground()
        if (cursor.moveToFirst()) {
            val idIndex = cursor.getColumnIndex( ContactsContract.Profile.NAME_RAW_CONTACT_ID)
            val txtIndex = cursor.getColumnIndex(ContactsContract.Profile.DISPLAY_NAME_PRIMARY)
            do {
                var id = cursor.getString(idIndex)
                var txt = cursor.getString(txtIndex)
                if (id != null && txtIndex != null) {
                    var mess = MyModel(id, txt, 0)
                    listSms.add(mess)
                }
            } while (cursor.moveToNext())
        }
        return listSms
    }
}
