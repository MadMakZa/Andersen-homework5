package shadow.step.homework5fragments.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import shadow.step.homework5fragments.R
import shadow.step.homework5fragments.data.Note
import shadow.step.homework5fragments.data.NoteList

class DetailsFragment : Fragment() {

    companion object {
        private const val NOTE_EXTRA_KEY = "NOTE_EXTRA_KEY"
        fun newInstance() = DetailsFragment()
    }

    private lateinit var editName: EditText
    private lateinit var editLastName: EditText
    private lateinit var editPhoneNumber: EditText
    private lateinit var buttonSave: Button
    private var idNote: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editName = activity?.findViewById(R.id.etName)!!
        editLastName = activity?.findViewById(R.id.etLastName)!!
        editPhoneNumber = activity?.findViewById(R.id.etPhoneNumber)!!
        buttonSave = activity?.findViewById(R.id.btnSave)!!

        val note = arguments?.getSerializable(NOTE_EXTRA_KEY) as Note
        editName.setText(note.name)
        editLastName.setText(note.lastName)
        editPhoneNumber.setText(note.phoneNumber)
        idNote = note.idNote

        init()
    }

    private fun init() {
        saveChanges(idNote)
    }

    private fun saveChanges(index: Int) {
        buttonSave.setOnClickListener {
            val note = Note(
                editName.text.toString(),
                editLastName.text.toString(),
                editPhoneNumber.text.toString(),
                idNote
            )
            NoteList.arrayListNote[index - 1] = note

            if (SizingDevice.isTablet(requireContext().applicationContext)) {
                activity?.supportFragmentManager?.beginTransaction()!!
                    .replace(R.id.container, MainActivity.newInstance().mainFragment)
                    .commit()
                //костыль
                startActivityForResult(Intent(requireContext().applicationContext,
                    MainActivity::class.java), 1)
                activity?.finish()

                activity?.onBackPressed()

            } else {
                childFragmentManager.beginTransaction()
                    .detach(MainFragment())
                    .attach(MainFragment())
                    .commit()
            }
        }
    }
}