package com.mck.study5.product_service.services.subjects;

import com.mck.study5.product_service.constants.MessageKeys;
import com.mck.study5.product_service.exceptions.DataNotFoundException;
import com.mck.study5.product_service.models.Subject;
import com.mck.study5.product_service.repositories.SubjectRepository;

import com.mck.study5.product_service.dtos.request.subject.SubjectDTO;
import com.mck.study5.product_service.responses.subject.SubjectListResponse;
import com.mck.study5.product_service.responses.subject.SubjectResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService implements ISubjectService{
    private final SubjectRepository subjectRepository;

    @Override
    public SubjectListResponse getSubjects() {
        List<SubjectResponse> subjectResponses = subjectRepository
                .findAll()
                .stream().map(Subject::toResponse).toList();
        return SubjectListResponse.builder()
                .quantity(subjectResponses.size())
                .subjects(subjectResponses)
                .build();
    }

    @Override
    public SubjectResponse createOrUpdateSubject(SubjectDTO dto) {
       Subject subject;
       if(dto.getId()!=null){
           subject = subjectRepository.findById(dto.getId()).get();
       }
       else{
           subject = new Subject();
       }
       subject.setName(dto.getName());
       subjectRepository.save(subject);
       return Subject.toResponse(subject);
    }

    @Override
    public SubjectResponse deleteSubject(Long id) {
       Subject subject = subjectRepository.findById(id)
               .orElseThrow(()->new DataNotFoundException(MessageKeys.SUBJECT_NOT_FOUND));
       subjectRepository.delete(subject);
       return Subject.toResponse(subject);
    }
}
