package umc.product.domain.mcp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.product.domain.mcp.dto.response.readmodel.TestReadDto;
import umc.product.domain.mcp.entity.Mcp;
import umc.product.domain.mcp.mapper.McpMapper;
import umc.product.domain.mcp.repository.McpRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class McpServiceImpl implements McpService {

	private final McpMapper mcpMapper;
	private final McpRepository mcpRepository;
	@Override
    public Mcp addMcp(){
		 return null;
	}

	@Override
	public TestReadDto getMcpById(Long id){
		Mcp mcp = mcpRepository.findById(id).orElse(null);
		return mcpMapper.testMapper(mcp);
	}

	@Override
	public List<Mcp> getAllMcps(){
		return null;
	}

	@Override
	public void deleteMcpById(Long id){

	}

	@Override
	public Mcp updateMcp(){
		return null;
	};
}
