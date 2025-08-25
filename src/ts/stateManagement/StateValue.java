package ts.stateManagement;

public interface StateValue {
    /**
     * يحصل على نوع القيمة
     */
    ValueType getType();

    /**
     * يحول القيمة إلى تمثيل سلسلة
     */
    String toString();

    /**
     * يحول القيمة إلى تمثيل يمكن استخدامه في توليد الأكواد
     */
    String toCodeString();
}