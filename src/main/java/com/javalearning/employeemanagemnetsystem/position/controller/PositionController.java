package com.javalearning.employeemanagemnetsystem.position.controller;

import com.javalearning.employeemanagemnetsystem.position.dto.*;
import com.javalearning.employeemanagemnetsystem.position.service.PositionService;
import com.javalearning.employeemanagemnetsystem.shared.data.enums.Status;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees/positions")
@AllArgsConstructor
public class PositionController {

    private final PositionService positionService;

    @PostMapping
    public PositionResponse createPosition(
            @RequestBody CreatePositionRequest createPositionRequest
    )
    {return positionService.createPosition(createPositionRequest);}

    @GetMapping("/template")
    public PositionTemplateResponse getPositionTemplate(){
        return new PositionTemplateResponse(
                Status.listInfo()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePositionById(
            @PathVariable Long id
    ){
        positionService.deletePositionById(id);
        return ResponseEntity.ok("Position with id " + id + " had been deleted!");
    }

    @GetMapping("/{id}")
    public PositionResponse retrieveById(@PathVariable Long id){
        return positionService.retrievePositionById(id);
    }

    @GetMapping
    List<PositionResponse> retrieveAll(){
        return positionService.retrieveAll();
    }

    @PutMapping
    public PositionResponse updateById(
            @PathVariable Long id,
            @RequestBody  UpdatePositionRequest updatePositionRequest){
        return positionService.updatePositionById(id, updatePositionRequest);
    }

    @PatchMapping
    public PositionResponse updatePositionStatus(
            @PathVariable Long id,
            @RequestBody UpdatePositionStatusRequest updatePositionStatusRequest
            ){
        return positionService.updatePositionStatus(id, updatePositionStatusRequest);
    }

}
