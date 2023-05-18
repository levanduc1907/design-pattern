package entity.shipping;

import entity.order.Order;
import org.example.DistanceCalculator;

/**
 * Vi phạm OCP, DIP: Lớp DeliveryInfo đang phụ thuộc trực tiếp vào lớp DistanceCalculator.
 * Trong tương lai, khi muốn thay đổi cách tính khoảng cách, sử dụng thư viện mới (all-distance-api.jar có interface gần giống với distance-api.jar)
 * thì lớp này bắt buộc phải sửa đổi.
 */
public class DeliveryInfo {

    protected String name;
    protected String phone;
    protected String province;
    protected String address;
    protected String shippingInstructions;
    protected DistanceCalculator distanceCalculator;

    public DeliveryInfo(String name, String phone, String province, String address, String shippingInstructions, DistanceCalculator distanceCalculator) {
        this.name = name;
        this.phone = phone;
        this.province = province;
        this.address = address;
        this.shippingInstructions = shippingInstructions;
        this.distanceCalculator = distanceCalculator;
    }

/**
 * Vi phạm OCP: Trong tương lai, khi muốn thay đổi công thức tính phí vận chuyển thì sẽ phải sửa đổi trực tiếp nội dung phương thức calculateShippingFee
 */
    public int calculateShippingFee(Order order) {
        int distance = distanceCalculator.calculateDistance(address, province);
        return (int) (distance * 1.2);
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getProvince() {
        return province;
    }

    public String getAddress() {
        return address;
    }

    public String getShippingInstructions() {
        return shippingInstructions;
    }
}
