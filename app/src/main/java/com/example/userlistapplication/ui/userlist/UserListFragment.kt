package com.example.userlistapplication.ui.userlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentUserListBinding
import com.example.userlistapplication.network.UserProviderImpl

class UserListFragment : Fragment() {

    private val binding get() = _binding!!
    private var _binding: FragmentUserListBinding? = null
    private lateinit var viewModel: UserListViewModel
    private lateinit var userListAdapter: UserListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // INI RECYCLER VIEW
        val recyclerView: RecyclerView = root.findViewById(R.id.home_user_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // INI ADAPTER AND CLICK LISTENER
        userListAdapter = UserListAdapter(emptyList()) { user ->
            showUserDetailFragment(user.name, user.email, user.address.toString())
        }
        recyclerView.adapter = userListAdapter

        // INI VIEW MODEL AND UPDATE ADAPTER
        viewModel = UserListViewModel(UserProviderImpl()).apply {
            iniViewModel()
            users.observe(viewLifecycleOwner) { users ->
                users?.let { userListAdapter.updateUsers(it) }
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * Navigate to [UserListFragment]
     */
    private fun showUserDetailFragment(name: String, email: String, address: String) {
        val action = UserListFragmentDirections
            .actionHomeFragmentToUserProfileFragment(name, email, address)
        findNavController().navigate(action)
    }

}