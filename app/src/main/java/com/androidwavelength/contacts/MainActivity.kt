package com.androidwavelength.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidwavelength.contacts.adapters.CallsAdapter
import com.androidwavelength.contacts.models.Advertisement
import com.androidwavelength.contacts.models.CallInfo


class MainActivity : AppCompatActivity() {

    private lateinit var recycleCalls : RecyclerView

    private val callsInfo = ArrayList<CallInfo>()
    private val advertisements = ArrayList<Advertisement>()
    private lateinit var callsAdapter : CallsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        initViews()
        setupListeners()
    }

    private fun setupListeners() {
        callsAdapter.onAdvertisementClickListener =
            object : CallsAdapter.OnAdvertisementClickListener {
                override fun onAdvertisementClick(advertisement: Advertisement, advPosition: Int) {
                    mt("Adv: ${advertisement.title}")
                }
            }

        callsAdapter.onCallInfoClickListener =
            object : CallsAdapter.OnCallInfoClickListener {
            override fun onContactImageClick(callInfo: CallInfo, callPosition: Int) {
                mt("Call Info Image: ${callInfo.ContactName}")
            }

            override fun onContactNameClick(callInfo: CallInfo, callPosition: Int) {
                mt("Call Info Number: ${callInfo.ContactName}")
            }

            override fun onContactNumberClick(callInfo: CallInfo, callPosition : Int) {
                mt("Call Info Number: ${callInfo.ContactName}")
            }
        }
    }

    private fun initData() {
        callsInfo.add(
            CallInfo(
                null,
                "9327382391",
                R.drawable.contact_image,
                System.currentTimeMillis(),
                CallInfo.TYPE_INCOMING.toByte()
            )
        )
        callsInfo.add(
            CallInfo(
                "Swapnil Nikam",
                "8421408934",
                R.drawable.contact_image,
                System.currentTimeMillis(),
                CallInfo.TYPE_INCOMING.toByte()
            )
        )
        callsInfo.add(
            CallInfo(
                "Deepali Karnekar",
                "9011131282",
                R.drawable.contact_image,
                System.currentTimeMillis(),
                CallInfo.TYPE_OUTGOING.toByte()
            )
        )
        callsInfo.add(
            CallInfo(
                "Jaywant Karnekar",
                "9763970976",
                R.drawable.contact_image,
                System.currentTimeMillis(),
                CallInfo.TYPE_INCOMING.toByte()
            )
        )
        callsInfo.add(
            CallInfo(
                "Sia Karmarkar",
                "8888302050",
                R.drawable.contact_image,
                System.currentTimeMillis(),
                CallInfo.TYPE_INCOMING.toByte()
            )
        )
        callsInfo.add(
            CallInfo("Swapnil Nikam",
                "7972779208",
                R.drawable.contact_image,
                System.currentTimeMillis(),
                CallInfo.TYPE_OUTGOING.toByte()
            )
        )
        callsInfo.add(
            CallInfo(
                "Sia Karmarkar",
                "9121223145",
                R.drawable.contact_image,
                System.currentTimeMillis(),
                CallInfo.TYPE_INCOMING.toByte()
            )
        )
        callsInfo.add(
            CallInfo(
                "Maithilee Karnekar",
                "7887777044",
                R.drawable.contact_image,
                System.currentTimeMillis(),
                CallInfo.TYPE_OUTGOING.toByte()
            )
        )
        callsInfo.add(
            CallInfo(
                "Yogi",
            "9327382891",
            R.drawable.contact_image,
            System.currentTimeMillis(),
            CallInfo.TYPE_INCOMING.toByte()
            )
        )
        callsInfo.add(
            CallInfo(
                "Sia Karmarkar",
                "9327384391",
                R.drawable.contact_image,
                System.currentTimeMillis(),
                CallInfo.TYPE_INCOMING.toByte()
            )
        )
        callsInfo.add(
            CallInfo(
                "Rutuja Kamat",
                "9329882391",
                R.drawable.contact_image,
                System.currentTimeMillis(),
                CallInfo.TYPE_INCOMING.toByte()
            )
        )
        callsInfo.add(
            CallInfo(
                "Felix Squarepants",
                "9327370891",
                R.drawable.contact_image,
                System.currentTimeMillis(),
                CallInfo.TYPE_INCOMING.toByte()
            )
        )
        callsInfo.add(
            CallInfo(
                "Sia Karmarkar",
                "9325582391",
                R.drawable.contact_image,
                System.currentTimeMillis(),
                CallInfo.TYPE_INCOMING.toByte()
            )
        )

        advertisements.add(
            Advertisement(
                "Get Job in 30 days!",
                R.drawable.tech,
                "https://bitcode.in"
            )
        )
        advertisements.add(
            Advertisement(
                "Get Job Without Degree!",
                R.drawable.tech,
                "https://bitcode.in"
            )
        )
        advertisements.add(
            Advertisement(
                "Get Job at Google",
                R.drawable.tech,
                "https://bitcode.in"
            )
        )
        advertisements.add(
            Advertisement(
                "Facebook is waiting for you!",
                R.drawable.tech,
                "https://bitcode.in"
            )
        )
        advertisements.add(
            Advertisement(
                "Leave Bitcode and get a Job!",
                R.drawable.tech,
                "https://bitcode.in"
            )
        )
    }

    private fun initViews() {
        recycleCalls = findViewById(R.id.recycleCalls)
        recycleCalls.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        callsAdapter = CallsAdapter(callsInfo, advertisements)
        recycleCalls.adapter = callsAdapter
    }

    private fun mt(text : String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}