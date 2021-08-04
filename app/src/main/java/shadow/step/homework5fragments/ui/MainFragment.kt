package shadow.step.homework5fragments.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import shadow.step.homework5fragments.R
import shadow.step.homework5fragments.data.NoteList.arrayListNote

class MainFragment : Fragment() {

    companion object {
        private const val NOTE_EXTRA_KEY = "NOTE_EXTRA_KEY"
        fun newInstance() = MainFragment()
    }

    private lateinit var item1: CardView
    private lateinit var item2: CardView
    private lateinit var item3: CardView
    private lateinit var item4: CardView
    private lateinit var tvNameNoteOne: TextView
    private lateinit var tvNameNoteTwo: TextView
    private lateinit var tvNameNoteThree: TextView
    private lateinit var tvNameNoteFour: TextView
    private lateinit var tvLastNameNoteOne: TextView
    private lateinit var tvLastNameNoteTwo: TextView
    private lateinit var tvLastNameNoteThree: TextView
    private lateinit var tvLastNameNoteFour: TextView
    private lateinit var tvPhoneNumberNoteOne: TextView
    private lateinit var tvPhoneNumberNoteTwo: TextView
    private lateinit var tvPhoneNumberNoteThree: TextView
    private lateinit var tvPhoneNumberNoteFour: TextView
    private lateinit var arrayItems: ArrayList<CardView>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        item1 = activity?.findViewById(R.id.idNoteOne)!!
        item2 = activity?.findViewById(R.id.idNoteTwo)!!
        item3 = activity?.findViewById(R.id.idNoteThree)!!
        item4 = activity?.findViewById(R.id.idNoteFour)!!
        tvNameNoteOne = activity?.findViewById(R.id.tvNameNoteOne)!!
        tvNameNoteTwo = activity?.findViewById(R.id.tvNameNoteTwo)!!
        tvNameNoteThree = activity?.findViewById(R.id.tvNameNoteThree)!!
        tvNameNoteFour = activity?.findViewById(R.id.tvNameNoteFour)!!
        tvLastNameNoteOne = activity?.findViewById(R.id.tvLastNameNoteOne)!!
        tvLastNameNoteTwo = activity?.findViewById(R.id.tvLastNameNoteTwo)!!
        tvLastNameNoteThree = activity?.findViewById(R.id.tvLastNameNoteThree)!!
        tvLastNameNoteFour = activity?.findViewById(R.id.tvLastNameNoteFour)!!
        tvPhoneNumberNoteOne = activity?.findViewById(R.id.tvPhoneNumberNoteOne)!!
        tvPhoneNumberNoteTwo = activity?.findViewById(R.id.tvPhoneNumberNoteTwo)!!
        tvPhoneNumberNoteThree = activity?.findViewById(R.id.tvPhoneNumberNoteThree)!!
        tvPhoneNumberNoteFour = activity?.findViewById(R.id.tvPhoneNumberNoteFour)!!
        arrayItems = arrayListOf(item1, item2, item3, item4)
        init()
    }

    private fun init() {
        fillNoteViews()
        openCurrentNoteDetails()
    }

    private fun openDetailsFragmentInTablet(tag: String) {
        val fragmentDetails = DetailsFragment.newInstance()
        val bundle = Bundle()
        bundle.putSerializable(NOTE_EXTRA_KEY, arrayListNote[tag.toInt() - 1])
        fragmentDetails.arguments = bundle
        activity?.supportFragmentManager?.beginTransaction()!!
            .add(R.id.containerTablet2, fragmentDetails)
            .addToBackStack(null)
            .commit()
    }

    private fun openDetailsFragment(tag: String) {
        val fragmentDetails = DetailsFragment()
        val bundle = Bundle()
        bundle.putSerializable(NOTE_EXTRA_KEY, arrayListNote[tag.toInt() - 1])
        fragmentDetails.arguments = bundle
        activity?.supportFragmentManager?.beginTransaction()!!
            .replace(R.id.container, fragmentDetails)
            .addToBackStack(null)
            .commit()
    }

    private fun openCurrentNoteDetails() {
        if (SizingDevice.isTablet(requireContext().applicationContext)) {
            for (item in arrayItems) {
                item.setOnClickListener {
                    openDetailsFragmentInTablet(item.tag.toString())
                }
            }
        } else {
            for (item in arrayItems) {
                item.setOnClickListener {
                    openDetailsFragment(item.tag.toString())
                }
            }
        }
    }

    fun fillNoteViews() {
        //note one
        tvNameNoteOne.text = arrayListNote[0].name
        tvLastNameNoteOne.text = arrayListNote[0].lastName
        tvPhoneNumberNoteOne.text = arrayListNote[0].phoneNumber
        //note two
        tvNameNoteTwo.text = arrayListNote[1].name
        tvLastNameNoteTwo.text = arrayListNote[1].lastName
        tvPhoneNumberNoteTwo.text = arrayListNote[1].phoneNumber
        //note three
        tvNameNoteThree.text = arrayListNote[2].name
        tvLastNameNoteThree.text = arrayListNote[2].lastName
        tvPhoneNumberNoteThree.text = arrayListNote[2].phoneNumber
        //note four
        tvNameNoteFour.text = arrayListNote[3].name
        tvLastNameNoteFour.text = arrayListNote[3].lastName
        tvPhoneNumberNoteFour.text = arrayListNote[3].phoneNumber
    }
}