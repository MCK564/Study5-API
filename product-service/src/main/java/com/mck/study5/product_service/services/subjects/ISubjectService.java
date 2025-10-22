package com.mck.study5.product_service.services.subjects;

import com.mck.study5.product_service.dtos.request.subject.SubjectDTO;
import dtos.response.subject.SubjectListResponse;
import dtos.response.subject.SubjectResponse;
import org.springframework.stereotype.Service;

@Service
public interface ISubjectService {
    SubjectListResponse  getSubjects();
    SubjectResponse createOrUpdateSubject(SubjectDTO dto);
    SubjectResponse deleteSubject(Long id);
}
