package com.example.userlistapplication.ui.userlist

import android.os.Bundle
import androidx.navigation.NavDirections
import com.example.myapplication.R
import kotlin.Int
import kotlin.String

public class UserListFragmentDirections private constructor() {
  private data class ActionHomeFragmentToUserProfileFragment(
    public val name: String,
    public val email: String,
    public val address: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_homeFragment_to_userProfileFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("name", this.name)
        result.putString("email", this.email)
        result.putString("address", this.address)
        return result
      }
  }

  public companion object {
    public fun actionHomeFragmentToUserProfileFragment(
      name: String,
      email: String,
      address: String,
    ): NavDirections = ActionHomeFragmentToUserProfileFragment(name, email, address)
  }
}
