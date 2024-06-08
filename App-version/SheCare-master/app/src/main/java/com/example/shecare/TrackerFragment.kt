package com.example.shecare

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TrackerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TrackerFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var phasetext: TextView
    lateinit var year:String
    lateinit var month:String
    lateinit var day:String
    private lateinit var dayscount: TextView
    private lateinit var calenderbtn: ImageView
    private lateinit var calenderredirect: DatePicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tracker, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dayscount=view.findViewById(R.id.DaysCount)
        phasetext=view.findViewById(R.id.phase)
        calenderbtn=view.findViewById(R.id.Cal)
        calenderredirect=view.findViewById((R.id.CalRedirect))
        calenderredirect.visibility=View.GONE
        year= (activity as ActionActivity).year
        month = (activity as ActionActivity).month
        day=(activity as ActionActivity).day
        var diff= getdifference()

        dayscount.text=diff.toString()
        updatephase(diff)
        calenderbtn.setOnClickListener {

            if (calenderredirect.visibility == View.GONE) {
                dayscount.visibility = View.GONE
                phasetext.visibility = View.GONE
                calenderredirect.visibility = View.VISIBLE

                calenderredirect.init(year.toInt(), month.toInt(), day.toInt()) { view, y, m, d ->
                    year = y.toString()
                    month = (m + 1).toString()
                    day = d.toString()
                    diff=getdifference()
                    dayscount.text=diff.toString()
                    updatephase(diff)
                }
            }

                else{
                    dayscount.visibility = View.VISIBLE
                    phasetext.visibility = View.VISIBLE
                    calenderredirect.visibility = View.GONE
                }

            }






    }
    @RequiresApi(Build.VERSION_CODES.O)
    public fun getdifference():Int{
        val mDate1=LocalDate.of(year.toInt(),month.toInt(),day.toInt())
        val mDate2= LocalDate.now()

        val period=Period.between(mDate1,mDate2)
        return period.days
    }
    public fun updatephase(diff:Int){
        if (diff<=5)
            phasetext.text="Menstruation"
        else if (diff>5 && diff<=13)
            phasetext.text="Follicular Phase"
        else if(diff>13 && diff<=15)
            phasetext.text="Ovulation Phase"
        else
            phasetext.text="Luteal Phase"
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TrackerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TrackerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}