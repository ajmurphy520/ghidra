package ghidra.program.model.data;

import ghidra.docking.settings.*;

import java.math.*;

public class FixedPointPrecisionSettingsDefinition implements NumberSettingsDefinition {

    private static final String SETTING_NAME = "fixed_point_divisor";
    private static final String DESCRIPTION = "Set the common divisor to use to interpret data as fixed point value";
    private static final String DISPLAY_NAME = "Fixed Point";
    private static final BigInteger MAX_VALUE = BigInteger.valueOf(Long.MAX_VALUE);

    private static final int DEFAULT = 1;

    public static final FixedPointPrecisionSettingsDefinition DEF = new FixedPointPrecisionSettingsDefinition();

    private FixedPointPrecisionSettingsDefinition() {
    }

    @Override
    public long getValue(Settings settings) {
        if (settings == null) {
            return DEFAULT;
        }
        Long value = settings.getLong(SETTING_NAME);
        if (value == null) {
            return DEFAULT;
        }
        return value;
    }

    @Override
    public void setValue(Settings settings, long value) {
        if (value <= DEFAULT) {
            settings.clearSetting(SETTING_NAME);
        } else {
            settings.setLong(SETTING_NAME, value);
        }
    }

    @Override
    public BigInteger getMaxValue() {
        return MAX_VALUE;
    }

    @Override
    public boolean allowNegativeValue() {
        return false;
    }

    @Override
    public boolean isHexModePreferred() {
        return false;
    }

    @Override
    public boolean hasValue(Settings setting) {
        return getValue(setting) != DEFAULT;
    }

    @Override
    public String getValueString(Settings settings) {
        return NumberSettingsDefinition.super.getValueString(settings);
    }

    @Override
    public String getName() {
        return DISPLAY_NAME;
    }

    @Override
    public String getStorageKey() {
        return SETTING_NAME;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public void clear(Settings settings) {
        settings.clearSetting(SETTING_NAME);
    }

    @Override
    public void copySetting(Settings srcSettings, Settings destSettings) {
        Long value = srcSettings.getLong(SETTING_NAME);
        if (value == null) {
            destSettings.clearSetting(SETTING_NAME);
        } else {
            destSettings.setLong(SETTING_NAME, value);
        }
    }

    @Override
    public boolean hasSameValue(Settings settings1, Settings settings2) {
        return NumberSettingsDefinition.super.hasSameValue(settings1, settings2);
    }

}
