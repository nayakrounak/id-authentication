package io.mosip.kernel.smsnotification.msg91.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.mosip.kernel.smsnotification.msg91.dto.SmsRequestDto;
import io.mosip.kernel.smsnotification.msg91.dto.SmsResponseDto;
import io.mosip.kernel.smsnotification.msg91.service.SmsNotificationService;

/**
 * This controller class receives contact number and message in data transfer
 * object and sends SMS on the provided contact number.
 * 
 * @author Ritesh Sinha
 * @since 1.0.0
 */

@CrossOrigin
@RestController
public class SmsNotificationController {

	/**
	 * The reference that autowire sms notification service class.
	 */
	@Autowired
	SmsNotificationService smsNotifierService;

	/**
	 * This method sends sms to the contact number provided.
	 * 
	 * @param smsRequestDto
	 *            the request dto for sms-notification.
	 * @return the status and message as dto response.
	 */
	@PostMapping(value = "/notification/sms")
	public ResponseEntity<SmsResponseDto> sendSmsNotification(@Valid @RequestBody SmsRequestDto smsRequestDto) {

		return new ResponseEntity<>(
				smsNotifierService.sendSmsNotification(smsRequestDto.getNumber(), smsRequestDto.getMessage()),
				HttpStatus.ACCEPTED);

	}

}
