package com.ksatria.pendaftaranpondokpesantren.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pendaftaranpondokpesantren.ui.RegistrationListAdapter
import com.ksatria.pendaftaranpondokpesantren.R
import com.ksatria.pendaftaranpondokpesantren.application.RegistrationApp
import com.ksatria.pendaftaranpondokpesantren.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!
    private lateinit var applicationContext: Context
    private val registrationViewModel: RegistrationViewModel by viewModels {
        RegistrationViewModelFactory((applicationContext as RegistrationApp).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val adapter = RegistrationListAdapter { registration ->
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(registration)
            findNavController().navigate(action)
        }

        binding.DataRecyclerView.adapter = adapter
        binding.DataRecyclerView.layoutManager = LinearLayoutManager(context)
        registrationViewModel.allRegistrations.observe(viewLifecycleOwner) { registrations ->
            registrations.let {
                if (registrations.isEmpty()) {
                    binding.EmptyImageView.visibility = View.VISIBLE
                    binding.IlustrasionImageView.visibility = View.VISIBLE
                } else {
                    binding.EmptyImageView.visibility = View.GONE
                    binding.IlustrasionImageView.visibility = View.GONE
                }
                adapter.submitList(registrations)
            }
        }

        binding.addFAB.setOnClickListener {
               val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(null)
               findNavController().navigate(action)
        }
    }
        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }
