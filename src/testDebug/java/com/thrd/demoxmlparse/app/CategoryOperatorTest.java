package com.thrd.demoxmlparse.app;

import android.content.res.AssetManager;
import android.content.res.Resources;
import com.fasterxml.aalto.stax.InputFactoryImpl;
import com.fasterxml.aalto.stax.OutputFactoryImpl;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.thrd.demoxmlparse.app.model.Categories;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Config(manifest = "src/testDebug/AndroidManifest.xml", emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class CategoryOperatorTest {

    private InputStream input;

    @Before
    public void setUp() throws Exception {
        String file = "groups.xml";
        Resources resources = Robolectric.application.getResources();
        AssetManager assetManager = resources.getAssets();
        try {
            input = assetManager.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
        input.close();

    }

    @Test
    public void testFileInput() {
        assertNotNull(input);
    }

    @Test
    public void testGetCategories() throws Exception {
        XmlFactory f = new XmlFactory(new InputFactoryImpl(), new OutputFactoryImpl());
        JacksonXmlModule module = new JacksonXmlModule();
        XmlMapper mapper = new XmlMapper(f, module);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        mapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
        Categories groups = mapper.readValue(input, Categories.class);
        int size = groups.getCategories().get(0).getCategoryOperators().size();
        System.out.println("groups = " + size);
        assertEquals(4, size);
    }
}