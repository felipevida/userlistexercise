package com.example.userlistapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.userlistapplication.data.*
import com.example.userlistapplication.network.UserProvider
import com.example.userlistapplication.ui.userlist.UserListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.*
import org.junit.rules.RuleChain
import org.junit.rules.TestRule
import org.mockito.Mockito.`when` import org.mockito.Mockito.mock

@OptIn(ExperimentalCoroutinesApi::class)
class UserListViewModelTest {

    private lateinit var viewModel: UserListViewModel
    private lateinit var userProvider: UserProvider

    private val mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var rule: TestRule = RuleChain.outerRule(mainCoroutineRule).around(InstantTaskExecutorRule())

    @Before
    fun setUp() {
        userProvider = mock(UserProvider::class.java)
        viewModel = UserListViewModel(userProvider)
    }

    @After
    fun tearDown() {
        // No need to resetMain as MainCoroutineRule handles it
    }

    @Test
    fun `test successful network response`() = runTest {
        viewModel.users = MutableLiveData()
        Assert.assertEquals(viewModel.users.isInitialized, false)

        val mockUsers = generateMockUsers()
        `when`(userProvider.fetchUsers()).thenReturn(mockUsers)

        val observer = mock(Observer::class.java) as Observer<List<User>>
        viewModel.users.observeForever(observer)

        viewModel.iniViewModel()

        Assert.assertNotNull(viewModel.users.value)
        Assert.assertEquals(1, viewModel.users.value?.size)
        Assert.assertEquals("John Doe", viewModel.users.value?.get(0)?.name)

        viewModel.users.removeObserver(observer)
        Assert.assertEquals(viewModel.users.isInitialized, true)
    }

    @Test
    fun `test network failure`() = runTest {
        viewModel.users = MutableLiveData()
        Assert.assertEquals(viewModel.users.isInitialized, false)

        // Simulate network failure by returning an empty list or null
        `when`(userProvider.fetchUsers()).thenReturn(MutableLiveData<List<User>>().apply { value = null })

        val observer = mock(Observer::class.java) as Observer<List<User>>
        viewModel.users.observeForever(observer)

        viewModel.iniViewModel()

        Assert.assertNull(viewModel.users.value)

        viewModel.users.removeObserver(observer)

        viewModel.users = MutableLiveData()
        Assert.assertEquals(viewModel.users.isInitialized, false)
    }

    /**
     * Generate a LiveData List of User
     */
    private fun generateMockUsers(): LiveData<List<User>> {
        val users = MutableLiveData<List<User>>()

        val geo = Geo(
            lat = "37.7749",
            lng = "-122.4194"
        )

        val address = Address(
            street = "123 Main St",
            suite = "Apt 4",
            city = "San Francisco",
            zipcode = "94103",
            geo = geo
        )

        val company = Company(
            name = "Tech Corp",
            catchPhrase = "Innovate and Inspire",
            bs = "Scalable solutions"
        )

        val user = User(
            id = 1,
            name = "John Doe",
            username = "johndoe",
            email = "john.doe@example.com",
            address = address,
            phone = "123-456-7890",
            website = "www.johndoe.com",
            company = company
        )

        users.value = listOf(user)

        return users
    }
}