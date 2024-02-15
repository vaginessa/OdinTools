package de.langerhans.odintools.tools

import de.langerhans.odintools.tools.DeviceType.*
import javax.inject.Inject

class DeviceUtils @Inject constructor(
    private val executor: ShellExecutor,
) {

    fun getDeviceVersion() = executor.getStringProperty(SettingsRepo.KEY_BUILD_VERSION, "")

    fun getDeviceVendor() = executor.getStringProperty(SettingsRepo.KEY_VENDOR_NAME, "")

    fun getDeviceType(): DeviceType {
        return when (getDeviceVendor()) {
            "Q9" -> ODIN2
            "4.0", "4.0P" -> RP4
            else -> OTHER
        }
    }
}

enum class DeviceType {
    ODIN2,
    RP4,
    OTHER,
}
