package com.asish.propertyfinder.controller;

import com.asish.propertyfinder.dto.AgentRequestDto;
import com.asish.propertyfinder.dto.AgentResponseDto;
import com.asish.propertyfinder.service.AgentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Api("REST API for Agent.")
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping("/add-agent")
    @ApiOperation(value = "API for add new Agent.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<Void> addAgent(@RequestBody AgentRequestDto agentRequestDto) {
        agentService.createAgent(agentRequestDto);
        return ResponseEntity.status(CREATED).build();
    }

    @GetMapping("/agents")
    @ApiOperation(value = "API for get all Properties.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 204, message = "No Content")
    })
    public ResponseEntity<List<AgentResponseDto>> getAllAgents() {
        return ResponseEntity.ok(agentService.getAllAgents());
    }

    @GetMapping("/agent/{agentId}")
    @ApiOperation(value = "API for get Agent by agent ID.", response = AgentRequestDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<AgentResponseDto> getAgentById(@PathVariable UUID agentId) {
        return ResponseEntity.ok(agentService.getAgentById(agentId));
    }

    @PutMapping("/agent/{agentId}")
    @ApiOperation(value = "API for update Agent by agent ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<Void> updateAgentById(@PathVariable UUID agentId, @RequestBody AgentRequestDto agentRequestDto) {
        agentService.updateAgent(agentId, agentRequestDto);
        return ResponseEntity.status(OK).build();
    }

    @DeleteMapping("/agent/{agentId}")
    @ApiOperation(value = "API for delete Agent by agent ID.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<Void> deleteAgentById(@PathVariable UUID agentId) {
        agentService.deleteAgent(agentId);
        return ResponseEntity.status(OK).build();
    }
}
