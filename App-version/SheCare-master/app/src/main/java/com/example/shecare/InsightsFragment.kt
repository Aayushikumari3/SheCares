package com.example.shecare

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InsightsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InsightsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var listViewAdapter: ExpandableListViewAdapter
    private lateinit var chapterList:List<String>
    private lateinit var topicList: HashMap<String, List<String>>
    private lateinit var eListView: ExpandableListView
    private lateinit var menses: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val let = arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }



            }

    private fun showList() {

        chapterList=ArrayList()
        topicList= HashMap()
        (chapterList as ArrayList<String>).add("Menstruation")


        val topic1 : MutableList<String> = ArrayList()
        topic1.add("Menstruation, commonly referred to as a period, is a natural process that occurs in most women of reproductive age. It involves the monthly shedding of the uterine lining, accompanied by the release of blood and other materials from the vagina. Menstruation is a crucial part of the menstrual cycle, which prepares the body for a potential pregnancy. Here's a comprehensive overview of menstruation:\n" +
                "\n" +
                "**1. Menstrual Cycle:** The menstrual cycle is a series of hormonal changes and events that occur in a woman's body each month. The cycle usually lasts between 21 to 35 days, with an average of 28 days. It is divided into two main phases:\n" +
                "\n" +
                "   - **Follicular Phase:** This phase begins on the first day of menstruation and lasts until ovulation. During this time, hormones stimulate the growth of follicles (fluid-filled sacs) in the ovaries, each containing an immature egg.\n" +
                "\n" +
                "   - **Luteal Phase:** After ovulation, the ruptured follicle transforms into the corpus luteum, which produces progesterone. If the egg is not fertilized, the corpus luteum degenerates, and hormone levels decrease, leading to menstruation.\n" +
                "\n" +
                "**2. Menstrual Period:** Menstruation is the bleeding phase of the menstrual cycle. It usually lasts for about 3 to 7 days, during which the uterine lining, which has thickened in preparation for a potential pregnancy, is shed because no pregnancy occurred.\n" +
                "\n" +
                "**3. Menstrual Blood:** Menstrual blood consists of blood, tissue from the uterine lining, and cervical mucus. The color and consistency of menstrual blood can vary throughout the period. It may start with bright red blood and become darker as the days progress.\n" +
                "\n" +
                "**4. Menstrual Products:** There are various products available to manage menstrual flow, including:\n" +
                "   - **Menstrual pads:** Absorbent pads worn in underwear to soak up menstrual blood.\n" +
                "   - **Tampons:** Small, cylindrical products inserted into the vagina to absorb menstrual blood.\n" +
                "   - **Menstrual cups:** Reusable cups made of silicone or rubber that are inserted into the vagina to collect menstrual blood.\n" +
                "   - **Period panties:** Special absorbent underwear designed to be worn during menstruation.\n" +
                "\n" +
                "**5. Menstrual Hygiene:** Maintaining proper menstrual hygiene is essential to prevent infections and discomfort. It includes changing menstrual products regularly, washing hands before and after handling menstrual products, and maintaining genital hygiene.\n" +
                "\n" +
                "**6. Menstrual Cycle and Fertility:** Menstruation is a sign of a woman's reproductive health, and the regularity of menstrual cycles can be an indicator of overall well-being. Women who have regular menstrual cycles are usually ovulating regularly, which is crucial for fertility.\n" +
                "\n" +
                "**7. Premenstrual Syndrome (PMS):** Some women may experience premenstrual symptoms, both physical and emotional, in the days leading up to menstruation. These symptoms can include bloating, breast tenderness, mood swings, and irritability.\n" +
                "\n" +
                "**8. Menstrual Disorders:** Some women may experience irregular periods or menstrual disorders that can be caused by various factors, such as hormonal imbalances, stress, or underlying medical conditions. Examples of menstrual disorders include amenorrhea (absence of menstruation), menorrhagia (heavy and prolonged periods), and dysmenorrhea (painful periods).\n" +
                "\n" +
                "It's important to remember that menstruation is a normal and healthy process. However, if you experience severe pain, heavy bleeding, or any other concerning symptoms during your period, it's essential to consult a healthcare provider to rule out any underlying issues and ensure your well-being.")
        topicList[chapterList[0]] = topic1
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insights, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eListView=view.findViewById(R.id.insights)
        menses=view.findViewById((R.id.menses))
        menses.movementMethod=ScrollingMovementMethod()
        showList()
        listViewAdapter= ExpandableListViewAdapter(context , chapterList,topicList)
        eListView.setAdapter(listViewAdapter)
        eListView.visibility=View.GONE


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment InsightsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InsightsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}