package uz.amirdev.roomtest.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.amirdev.roomtest.utils.Constants

@Database(entities = [Person::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao

    companion object {
        var instance: AppDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, "person")
                .allowMainThreadQueries()
                .build()

    }

}