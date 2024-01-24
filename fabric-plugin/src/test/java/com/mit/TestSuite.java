package com.mit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.googlecode.junittoolbox.ParallelSuite;
import com.googlecode.junittoolbox.SuiteClasses;

@RunWith(ParallelSuite.class)
@SuiteClasses({ "AppTest.class" })
public class TestSuite {
}