package com.example.jeep_need


import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.fragment.app.FragmentActivity

class SQLiteOpenHelper(context: FragmentActivity): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "acc.db"
        private const val DATABASE_VERSION = 1
        private const val Table_user = "driver"
        private const val Table_user2 = "passenger"

        private const val ID = "id"
        private const val NAME = "name"
        private const val PHONE = "phone"
        private const val EMAIL = "email"
        private const val PASSWORD = "password"
    }


    private val Create_Table = "Create Table $Table_user("+
            "$ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "$NAME TEXT,"+
            "$PHONE TEXT,"+
            "$EMAIL TEXT,"+
            "$PASSWORD TEXT)"
    private val Drop_Table = "DROP TABLE IF EXISTS $Table_user"
    private val Create_Table2 = "Create Table $Table_user2("+
            "$ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "$NAME TEXT,"+
            "$PHONE TEXT,"+
            "$EMAIL TEXT,"+
            "$PASSWORD TEXT)"
    private val Drop_Table2 = "DROP TABLE IF EXISTS $Table_user2"



    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(Create_Table)
        db?.execSQL(Create_Table2)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL(Drop_Table)
        db?.execSQL(Drop_Table2)
    }


    fun login_driver(email: String, password: String):Boolean{
        val columns = arrayOf(ID)
        val db = this.readableDatabase
        val selection = "$EMAIL = ? AND $PASSWORD = ?"
        val selectionArgs = arrayOf(email,password)

        val cursor = db.query(
            Table_user,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null
        )
        val cursorCount = cursor.count >0
        cursor.close()
        return  cursorCount

    }
    fun login_passenger(email: String, password: String):Boolean{
        val columns = arrayOf(ID)
        val db = this.readableDatabase
        val selection = "$EMAIL = ? AND $PASSWORD = ?"
        val selectionArgs = arrayOf(email,password)

        val cursor = db.query(
            Table_user2,
            columns,
            selection,
            selectionArgs,
            null,
            null,
            null
        )
        val cursorCount = cursor.count
        cursor.close()
        db.close()
        return  cursorCount > 0

    }

    fun register(name: String, phone: String, email:String, password: String):Boolean{
        val db = this.writableDatabase
        val value = ContentValues()

        value.put(NAME,name)
        value.put(PHONE,phone)
        value.put(EMAIL,email)
        value.put(PASSWORD,password)

        db.insert(Table_user, null, value)
        db.close()
        return false
    }
    fun register2(name: String, phone: String, email:String, password: String):Boolean{
        val db = this.writableDatabase
        val value = ContentValues()

        value.put(NAME,name)
        value.put(PHONE,phone)
        value.put(EMAIL,email)
        value.put(PASSWORD,password)

        db.insert(Table_user2, null, value)
        db.close()
        return false
    }
    //fun getAllDriverAcc():List<User_Driver>{
    //val columns = arrayOf(ID, NAME, EMAIL)
    //val sortOrder = "$NAME ASC"
    //val userList = arrayListOf<User_Driver>()
    // db = this.readableDatabase
    //val query = "SELECT * FROM $Table_user"
    //val cursor = db.rawQuery(query, null)

    //if(cursor.moveToFirst()){
    //do {
    //val id = cursor.getInt(cursor.getColumnIndexOrThrow(ID))
    //val name = cursor.getString(cursor.getColumnIndexOrThrow(NAME))
    //val email = cursor.getString(cursor.getColumnIndexOrThrow(EMAIL)
    //)
    //val user = User_Driver(id, name, email)
    //userList.add(user)
    //} while (cursor.moveToNext())
    //}
    //cursor.close()
    //db.close()
    //return userList
    //}


}