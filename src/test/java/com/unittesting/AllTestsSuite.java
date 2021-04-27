package com.unittesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.unittesting.business.ItemBusinessServiceTest;
import com.unittesting.controller.ItemControllerTest;
import com.unittesting.data.ItemRepositoryTest;

/**
 * 
 * @since 21.02
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ ItemRepositoryTest.class, ItemBusinessServiceTest.class, ItemControllerTest.class })
//@RunWith(JUnitPlatform.class)
//@SelectClasses({ TestItemRepository.class, TestItemBusinessService.class, TestItemController.class })
public class AllTestsSuite {

}
