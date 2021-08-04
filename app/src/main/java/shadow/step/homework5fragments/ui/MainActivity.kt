package shadow.step.homework5fragments.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import shadow.step.homework5fragments.R
import shadow.step.homework5fragments.ui.SizingDevice.isTablet

class MainActivity : AppCompatActivity() {

    companion object {
        fun newInstance() = MainActivity()
    }

    val mainFragment = MainFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setFragments()
    }
    private fun setFragments(){
        if (isTablet(this)) {
            installFragmentsForTablet()
        }else{
            installMainFragmentForSmartphone()
        }
    }
    private fun installMainFragmentForSmartphone() {
        supportFragmentManager.beginTransaction().run {
            add(R.id.container, mainFragment)
            this.commit()
        }
    }
    private fun installFragmentsForTablet() {
        supportFragmentManager.beginTransaction().run {
            add(R.id.container, mainFragment)
            this.commit()
        }
    }
}