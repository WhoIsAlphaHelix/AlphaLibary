/*
 *     Copyright (C) <2016>  <AlphaHelixDev>
 *
 *     This program is free software: you can redistribute it under the
 *     terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.alphahelix.alphalibary.core.utils;

import org.bukkit.ChatColor;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Util {

    /**
     * Rounds a {@link Double} up
     *
     * @param value     the {@link Double} to round
     * @param precision the precision to round up to
     * @return the rounded up {@link Double}
     * @see MathUtil#round(double, int)
     * @deprecated
     */
    public static double round(double value, int precision) {
        return MathUtil.round(value, precision);
    }

    /**
     * Creates a cooldown
     *
     * @param length       the lenght of the cooldown in ticks
     * @param key          the key to add a cooldown for
     * @param cooldownList the {@link List} where the key is in
     * @see ScheduleUtil#cooldown(int, Object, List)
     * @deprecated
     */
    public static <T> void cooldown(int length, final T key, final List<T> cooldownList) {
        ScheduleUtil.cooldown(length, key, cooldownList);
    }

    /**
     * @see ArrayUtil#makeArray(Object[])
     * @deprecated
     */
    public static <T> T[] makeArray(T... types) {
        return types;
    }
    
    /**
     * @see ArrayUtil#makePlayerArray(Player...)
     * @deprecated
     */
    public static Player[] makePlayerArray(Player... types) {
        return types;
    }
    
    /**
     * @see ArrayUtil#makePlayerArray(List)
     * @deprecated
     */
    public static Player[] makePlayerArray(List<String> types) {
        return ArrayUtil.makePlayerArray(types);
    }
    
    /**
     * @see ArrayUtil#makePlayerArray(Set)
     * @deprecated
     */
    public static Player[] makePlayerArray(Set<String> types) {
        return ArrayUtil.makePlayerArray(types);
    }
    
    /**
     * @see ScheduleUtil#runLater(long, boolean, Runnable)
     * @deprecated
     */
    public static void runLater(long ticks, boolean async, Runnable timer) {
        ScheduleUtil.runLater(ticks, async, timer);
    }
    
    /**
     * @see ScheduleUtil#runTimer(long, long, boolean, Runnable)
     * @deprecated
     */
    public static void runTimer(long wait, long ticks, boolean async, Runnable timer) {
        ScheduleUtil.runTimer(wait, ticks, async, timer);
    }
    
    /**
     * @see ItemUtil#isSame(ItemStack, ItemStack)
     * @deprecated
     */
    public static boolean isSame(ItemStack a, ItemStack b) {
        return ItemUtil.isSame(a, b);
    }
    
    /**
     * @see ItemUtil#isSameMeta(ItemMeta, ItemMeta)
     * @deprecated
     */
    private static boolean isSameMeta(ItemMeta a, ItemMeta b) {
        return false;
    }
    
    /**
     * @see StringUtil#generateRandomString(int)
     * @deprecated
     */
    public static String generateRandomString(int size) {
        return StringUtil.generateRandomString(size);
    }
    
    /**
     * @see MathUtil#toMultipleOfNine(int)
     * @deprecated
     */
    public static int toMultipleOfNine(int val) {
        return MathUtil.toMultipleOfNine(val);
    }

    public static void unzip(String zipPath, String outputFolder) {
        try {
            ZipFile zipFile = new ZipFile(zipPath);
            Enumeration<?> enu = zipFile.entries();

            File folder = new File(outputFolder);
            if (!folder.exists()) {
                folder.mkdir();
            }

            while (enu.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) enu.nextElement();

                String name = zipEntry.getName();

                File file = new File(outputFolder + File.separator + name);
                if (name.endsWith("/")) {
                    file.mkdirs();
                    continue;
                }

                File parent = file.getParentFile();
                if (parent != null) {
                    parent.mkdirs();
                }

                InputStream is = zipFile.getInputStream(zipEntry);
                FileOutputStream fos = new FileOutputStream(file);
                byte[] bytes = new byte[1024];
                int length;
                while ((length = is.read(bytes)) >= 0) {
                    fos.write(bytes, 0, length);
                }

                is.close();
                fos.close();
            }
            zipFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * @see ArrayUtil#getTypesOf(Class, List)
     * @deprecated
     */
    public static <T> List<T> getTypesOf(Class<T> clazzType, List<Object> inList) {
        return ArrayUtil.getTypesOf(clazzType, inList);
    }

    /**
     * Wraps the floor (round down) method from the net.minecraft.server MathHelper
     *
     * @param var0 the double to floor
     * @return the floored int
     * @see MathUtil#floor(double)
     * @deprecated
     */
    public static int floor(double var0) {
        return MathUtil.floor(var0);
    }

    /**
     * Converts a float into a angle
     *
     * @param v the float to convert
     * @return the converted angle as a byte
     * @see MathUtil#toAngle(float)
     * @deprecated
     */
    public static byte toAngle(float v) {
        return MathUtil.toAngle(v);
    }

    /**
     * Converts a double into a delta
     *
     * @param v the double to convert
     * @return the converted delta as a double
     * @see MathUtil#toDelta(double)
     * @deprecated
     */
    public static double toDelta(double v) {
        return MathUtil.toDelta(v);
    }
    
    /**
     * @see StringUtil#getProgessBar(int, int, int, char, ChatColor, ChatColor)
     * @deprecated
     */
    public static String getProgessBar(int current, int maximum, int total, char symbol, ChatColor completed, ChatColor uncompleted) {
        return StringUtil.getProgessBar(current, maximum, total, symbol, completed, uncompleted);
    }
    
    /**
     * @see ArrayUtil#replaceInArray(String, String, String...)
     * @deprecated
     */
    public static String[] replaceInArray(String pattern, String replace, String... array) {
        return ArrayUtil.replaceInArray(pattern, replace, array);
    }
    
    /**
     * @see StringUtil#isLong(String)
     * @deprecated
     */
    public static boolean isLong(String s) {
        return StringUtil.isLong(s);
    }
    
    /**
     * @see StringUtil#isDouble(String)
     * @deprecated
     */
    public static boolean isDouble(String s) {
        return StringUtil.isDouble(s);
    }
    
    /**
     * @see StringUtil#getFirstColors(String)
     * @deprecated
     */
    public static String getFirstColors(String input) {
        return StringUtil.getFirstColors(input);
    }
    
    /**
     * @see StringUtil#repeat(String, int)
     * @deprecated
     */
    public static String repeat(String string, int count) {
        return StringUtil.repeat(string, count);
    }

    public static Vector blockFaceToVector(BlockFace face, double length) {
        return new Vector(face.getModX(), face.getModY(), face.getModZ()).multiply(length);
    }
    
    /**
     * @see RotationUtil#rotatePitch(Vector, double)
     * @deprecated
     */
    public static Vector rotatePitch(Vector toRotate, double pitch) {
        return rotate(toRotate, 0, pitch);
    }
    
    /**
     * @see RotationUtil#rotate(Vector, double, double)
     * @deprecated
     */
    public static Vector rotate(Vector toRotate, double yaw, double pitch) {
        return rotate(toRotate, yaw, pitch, 0);
    }
    
    /**
     * @see RotationUtil#rotate(Vector, double, double, double)
     * @deprecated
     */
    public static Vector rotate(Vector toRotate, double yaw, double pitch, double roll) {
        return RotationUtil.rotate(toRotate, yaw, pitch, roll);
    }
    
    /**
     * @see RotationUtil#rotateYaw(Vector, double)
     * @deprecated
     */
    public static Vector rotateYaw (Vector toRotate, double yaw) {
        return rotate(toRotate, yaw, 0);
    }
    
    /**
     * @see RotationUtil#rotate(Vector, Vector, double)
     * @deprecated
     */
    public static Vector rotate(Vector toRotate, Vector around, double angle) {
        return RotationUtil.rotate(toRotate, around, angle);
    }
    
    /**
     * @see StringUtil#replaceLast(String, String, String)
     * @deprecated
     */
    public static String replaceLast(String string, String toReplace, String replacement) {
        return StringUtil.replaceLast(string, toReplace, replacement);
    }
    
    /**
     * @see StringUtil#upperEverything(List)
     * @deprecated
     */
    public static List<String> upperEverything(List<String> list) {
        return StringUtil.upperEverything(list);
    }
    
    /**
     * @see StringUtil#lowerEverything(List)
     * @deprecated
     */
    public static List<String> lowerEverything (List<String> list) {
        return StringUtil.upperEverything(list);
    }
}