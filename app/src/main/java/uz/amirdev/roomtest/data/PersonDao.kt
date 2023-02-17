package uz.amirdev.roomtest.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import uz.amirdev.roomtest.utils.Constants

@Dao
interface PersonDao {
    @Query("SELECT * FROM persont")
    fun getAllPerson(): LiveData<List<Person>>

    @Insert
    fun insertDate(person: Person)

    @Delete
    fun deleteData(person: Person)
}