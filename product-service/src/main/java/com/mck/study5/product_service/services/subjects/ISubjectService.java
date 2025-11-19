package com.mck.study5.product_service.services.subjects;

import com.mck.study5.product_service.dtos.request.subject.SubjectDTO;
import com.mck.study5.product_service.responses.subject.SubjectListResponse;
import com.mck.study5.product_service.responses.subject.SubjectResponse;
import org.springframework.stereotype.Service;


public interface ISubjectService {
    SubjectListResponse  getSubjects();
    SubjectResponse createOrUpdateSubject(SubjectDTO dto);
    SubjectResponse deleteSubject(Long id);


}
