/*
package com.androidapps.murad.nearby.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidapps.murad.nearby.R
import com.androidapps.murad.nearby.viewmodel.VenueViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.view.*

@AndroidEntryPoint
class VenueListFragment: Fragment() {

    private lateinit var _venueViewModel: VenueViewModel
    //var venueViewModel: VenueViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.main_menu, container,false)

        val adapter = VenueListAdapter()
        val recyclerView = view.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        _venueViewModel = ViewModelProvider(this).get(VenueViewModel::class.java)
        _venueViewModel.readAllData.observe(viewLifecycleOwner, Observer { venue ->
            adapter.setData(venue)
        })
        return view
    }

}*/
