package shadow.step.homework5fragments.data

import java.io.Serializable

data class Note(
    val name: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val idNote: Int = 0
) : Serializable

object NoteList {
    var arrayListNote: ArrayList<Note> = arrayListOf(
        Note("Maxim", "Afonsky", "+79819999999", 1),
        Note("Nadya", "Aksenova", "+79819999988", 2),
        Note("Maria", "Federova", "+79819999977", 3),
        Note("Katya", "Melnikova", "+79819999955", 4)
    )
}
