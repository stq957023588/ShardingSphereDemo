package com.fool.shardingspheredemo.mappers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fool.shardingspheredemo.domain.Order;
import com.fool.shardingspheredemo.domain.OrderDetail;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author fool
 * @date 2022/4/21 13:54
 */
@SpringBootTest
class OrderMapperTest {

    private OrderMapper orderMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Qualifier("stringLongRedisTemplate")
    @Autowired
    private RedisTemplate<String, Long> stringLongRedisTemplate;

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Test
    void orderSelectById() {
        Order order = orderMapper.selectById(103);
        System.out.println(order);
    }

    @Test
    void selectTest() {
        List<Long> collect = Stream.of(2L, 3L).collect(Collectors.toList());

        List<OrderDetail> orderDetails = orderDetailMapper.selectByOrderIdList(collect);
        orderDetails.forEach(System.out::println);

    }


    @Test
    void selectSingleTest() {
        List<OrderDetail> orderDetails = orderDetailMapper.selectByOrderId(2L);
        orderDetails.forEach(System.out::println);
    }

    @Test
    void insertCompleteWithOutKey() {
        Order order = new Order();

        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            order.setId(stringLongRedisTemplate.opsForValue().increment("order-key"));
            order.setNumber(UUID.randomUUID().toString().replace("-", ""));
            order.setTotalPrice(BigDecimal.valueOf(random.nextDouble() * 100 + 20));
            orderMapper.insert(order);

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(order.getId());

            int productNum = random.nextInt(10) + 1;

            for (int p = 0; p < productNum; p++) {
                orderDetail.setOrderId(order.getId());
                orderDetail.setProductId(random.nextInt(20));
                orderDetail.setQuantity(random.nextInt(20));
                orderDetail.setUnitPrice(BigDecimal.valueOf(random.nextDouble() * 300 + 5));
                orderDetailMapper.insertSelective(orderDetail);
                orderDetail.setId(null);
            }

        }
    }


    @Test
    void pageSelect() {
        ISelect select = () -> orderDetailMapper.selectByOrderIdList(Stream.of(216L, 217L).collect(Collectors.toList()));
        Page<OrderDetail> page = PageHelper.startPage(2, 10).doSelectPage(select);
        page.forEach(System.out::println);
    }

    @Test
    void insertOrder() {
        Order order = new Order();
        Random random = new Random();
        order.setId(stringLongRedisTemplate.opsForValue().increment("order-key"));
        order.setNumber(UUID.randomUUID().toString().replace("-", ""));
        order.setTotalPrice(BigDecimal.valueOf(random.nextDouble() * 100 + 20));
        orderMapper.insert(order);
        System.out.println(order);
    }


    @Test
    void insertOrderDetail() {
        Random random = new Random();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(1L);
        orderDetail.setProductId(random.nextInt(20));
        orderDetail.setQuantity(random.nextInt(20));
        orderDetail.setUnitPrice(BigDecimal.valueOf(random.nextDouble() * 300 + 5));

        orderDetailMapper.insertSelective(orderDetail);
    }

    @Test
    void readWriteSplitTest() {
        Order order = new Order();
        Random random = new Random();
        order.setId(stringLongRedisTemplate.opsForValue().increment("order-key"));
        order.setNumber(UUID.randomUUID().toString().replace("-", ""));
        order.setTotalPrice(BigDecimal.valueOf(random.nextDouble() * 100 + 20));
        orderMapper.insert(order);

        Order order1 = orderMapper.selectByPrimaryKey(order.getId());
        System.out.println(order1);
    }

    @Test
    void insertCompleteOrder() {
        Order order = new Order();

        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            order.setNumber(UUID.randomUUID().toString().replace("-", ""));
            order.setTotalPrice(BigDecimal.valueOf(random.nextDouble() * 100 + 20));
            orderMapper.insert(order);

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(order.getId());

            int productNum = random.nextInt(10);

            for (int p = 0; p < productNum; p++) {
                orderDetail.setProductId(random.nextInt(20));
                orderDetail.setQuantity(random.nextInt(20));
                orderDetail.setUnitPrice(BigDecimal.valueOf(random.nextDouble() * 300 + 5));

                orderDetailMapper.insertSelective(orderDetail);
                orderDetail.setId(null);
            }

        }

    }


    @Test
    void insertDetailTest() {
        Random random = new Random();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(2L);


        orderDetail.setProductId(1);
        orderDetail.setQuantity(2);
        orderDetail.setUnitPrice(BigDecimal.valueOf(random.nextDouble() * 300 + 5));

        orderDetailMapper.insertSelective(orderDetail);
    }

    @Test
    void insertShardingTest() {
        Order order = new Order();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            order.setNumber(UUID.randomUUID().toString().replace("-", ""));
            order.setTotalPrice(BigDecimal.valueOf(random.nextDouble() * 100 + 20));
            orderMapper.insert(order);
        }
    }

    @Test
    void selectByPrimary() {
        Order order = orderMapper.selectByPrimaryKey(204L);
        System.out.println(order);
    }

    @Test
    void selectByNumbers() {
        List<String> numbers = Stream.of("feedc99125d54505aff2d9683f469879", "f69546e5f12c4e76ade77a49f7cd827d").collect(Collectors.toList());
        List<Order> orders = orderMapper.selectByNumbers(numbers);
        orders.forEach(System.out::println);
    }

}
