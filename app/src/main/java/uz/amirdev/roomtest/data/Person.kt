package uz.amirdev.roomtest.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.amirdev.roomtest.utils.Constants

@Entity(tableName = "persont")
class Person {
    @PrimaryKey(autoGenerate = true)
    val id: Int

    @ColumnInfo(name = "name")
    val name: String

    @ColumnInfo(name = "age")
    val age: Int

    constructor(id: Int, name: String, age: Int) {
        this.id = id
        this.name = name
        this.age = age
    }
}