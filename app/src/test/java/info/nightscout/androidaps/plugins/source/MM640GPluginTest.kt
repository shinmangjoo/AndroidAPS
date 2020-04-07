package info.nightscout.androidaps.plugins.source

import dagger.android.AndroidInjector
import dagger.android.HasAndroidInjector
import info.nightscout.androidaps.TestBase
import info.nightscout.androidaps.database.AppRepository
import info.nightscout.androidaps.logging.AAPSLogger
import info.nightscout.androidaps.utils.GlucoseValueUploader
import info.nightscout.androidaps.utils.XDripBroadcast
import info.nightscout.androidaps.utils.resources.ResourceHelper
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest(AppRepository::class, XDripBroadcast::class, GlucoseValueUploader::class)
class MM640GPluginTest : TestBase() {

    private lateinit var mM640gPlugin: MM640gPlugin

    @Mock lateinit var resourceHelper: ResourceHelper
    @Mock lateinit var appRepository: AppRepository
    @Mock lateinit var xDripBroadcast: XDripBroadcast
    @Mock lateinit var glucoseValueUploader: GlucoseValueUploader

    @Before
    fun setup() {
        mM640gPlugin = MM640gPlugin(HasAndroidInjector { AndroidInjector { } }, resourceHelper, aapsLogger, appRepository, xDripBroadcast, glucoseValueUploader)
    }

    @Test fun advancedFilteringSupported() {
        Assert.assertEquals(false, mM640gPlugin.advancedFilteringSupported())
    }
}