package com.bc.mall.v2.server.controller;

import com.bc.mall.v2.server.entity.UserAddress;
import com.bc.mall.v2.server.enums.ResponseMsg;
import com.bc.mall.v2.server.service.UserAddressService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户
 *
 * @author zhou
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserAddressService userAddressService;

    /**
     * 新增用户收货地址
     *
     * @param userId    用户ID
     * @param name      收货人
     * @param phone     联系方式
     * @param province  省
     * @param city      市
     * @param district  区
     * @param address   详细地址
     * @param isDefault 是否默认地址
     * @return ResponseEntity
     */
    @ApiOperation(value = "新增用户收货地址", notes = "新增用户收货地址")
    @PostMapping(value = "/{userId}/address")
    public ResponseEntity<String> addUserAddress(
            @PathVariable String userId,
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam String province,
            @RequestParam String city,
            @RequestParam String district,
            @RequestParam String address,
            @RequestParam String isDefault) {
        ResponseEntity<String> responseEntity;
        try {
            UserAddress userAddress = new UserAddress(userId, name, phone, province,
                    city, district, address, isDefault);

            userAddressService.addUserAddress(userAddress);
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_USER_ADDRESS_SUCCESS.getResponseCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[addUserAddress] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_USER_ADDRESS_ERROR.getResponseCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    /**
     * 修改用户收货地址
     *
     * @param userId    用户ID
     * @param addressId 地址ID
     * @param name      收货人
     * @param phone     联系方式
     * @param province  省
     * @param city      市
     * @param district  区
     * @param address   详细地址
     * @param isDefault 是否默认地址
     * @return ResponseEntity
     */
    @ApiOperation(value = "修改用户收货地址", notes = "修改用户收货地址")
    @PutMapping(value = "/{userId}/address/{addressId}")
    public ResponseEntity<String> updateUserAddress(
            @PathVariable String userId,
            @PathVariable String addressId,
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam String province,
            @RequestParam String city,
            @RequestParam String district,
            @RequestParam String address,
            @RequestParam String isDefault) {
        ResponseEntity<String> responseEntity;
        try {
            UserAddress userAddress = new UserAddress(addressId, userId, name, phone, province,
                    city, district, address, isDefault);

            userAddressService.updateUserAddress(userAddress);
            responseEntity = new ResponseEntity<>(ResponseMsg.UPDATE_USER_ADDRESS_SUCCESS.getResponseCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[updateUserAddress] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(ResponseMsg.UPDATE_USER_ADDRESS_ERROR.getResponseCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


    /**
     * 获取用户收货地址列表
     *
     * @param userId 用户ID
     * @return ResponseEntity
     */
    @ApiOperation(value = "获取用户收货地址列表", notes = "获取用户收货地址列表")
    @GetMapping(value = "/{userId}/address")
    public ResponseEntity<List<UserAddress>> getUserAddressList(
            @PathVariable String userId) {
        ResponseEntity<List<UserAddress>> responseEntity;
        try {
            List<UserAddress> userAddressList = userAddressService.getUserAddressList(userId);
            responseEntity = new ResponseEntity<>(userAddressList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[getUserAddressList] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    /**
     * 删除用户收货地址
     *
     * @param addressId 地址ID
     * @return ResponseEntity
     */
    @ApiOperation(value = "删除用户收货地址", notes = "删除用户收货地址")
    @DeleteMapping(value = "/{userId}/address/{addressId}")
    public ResponseEntity<String> deleteUserAddress(
            @PathVariable String addressId) {
        ResponseEntity<String> responseEntity;
        try {
            userAddressService.deleteUserAddress(addressId);
            responseEntity = new ResponseEntity<>(ResponseMsg.DELETE_USER_ADDRESS_SUCCESS.getResponseCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[deleteUserAddress] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(ResponseMsg.DELETE_USER_ADDRESS_ERROR.getResponseCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}