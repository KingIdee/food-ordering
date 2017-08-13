package com.androidbytes.foodordering;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by idee on 8/13/17.
 */

@SuppressWarnings("unchecked")
@RunWith(JUnit4.class)
public class RestaurantListViewModelTest {

    private RestaurantListRepository repository;
    private RestaurantListViewModel viewModel;

    @Before
    public void setup(){
        /**
         * Initialization of objects to be used during tests
         */
        repository = mock(RestaurantListRepository.class);
        viewModel = new RestaurantListViewModel();
    }

    @Test
    public void testNull() throws Exception {

        /**
         * Check that the view model and repository is initialized
         */
        assertThat(viewModel,notNullValue());
        assertThat(repository,notNullValue());

    }

    @Test
    public void checkLiveDataNotNull() throws Exception {

        /**
         * Initialize the live data object in the view model class
         */
        viewModel.init();

        /**
         * Check that the live data returned is not null
         */
        assertThat(viewModel.getRestaurants(),notNullValue());

    }

    @Test
    public void checkReturnedValues(){

        /**
         * Invalidate value of the LiveData
         */
        viewModel.nullify();

        /**
         * Initialize the live data object in the view model class
         */
        viewModel.init();

        /**
         * Check that the value supplied by the repository class is the same supplied by the view model class to the activity
         * This test currently fails, I'll fix in next commit
         */
        assertEquals(viewModel.getRestaurants() ,repository.getR() );

    }

}