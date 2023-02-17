package uz.amirdev.roomtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.amirdev.roomtest.data.AppDatabase
import uz.amirdev.roomtest.data.Person

class MainActivity : AppCompatActivity() {

    lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = AppDatabase(this)
//        putData()
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        val allPerson = db.personDao().getAllPerson()
        allPerson.observe(this) { personList ->
            for (person in personList) {
                println("Ma'lumot: ${person.id} -> ${person.name}")
            }
        }
    }

    private fun putData() {
        for (i in 1..100)
            db.personDao().insertDate(Person(0, "Muzaffar", 20))
    }
}