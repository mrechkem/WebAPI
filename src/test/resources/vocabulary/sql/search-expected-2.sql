select CONCEPT_ID, CONCEPT_NAME, ISNULL(STANDARD_CONCEPT,'N') STANDARD_CONCEPT, ISNULL(INVALID_REASON,'V') INVALID_REASON, CONCEPT_CODE, CONCEPT_CLASS_ID, DOMAIN_ID, VOCABULARY_ID, VALID_START_DATE, VALID_END_DATE
from omop_v5.concept
where (LOWER(CONCEPT_NAME) LIKE ? or LOWER(CONCEPT_CODE) LIKE ? or CAST(CONCEPT_ID as VARCHAR(255)) = ?)
 AND DOMAIN_ID IN (?,?,?,?,?) AND VOCABULARY_ID IN (?,?,?,?,?,?,?,?,?,?) AND CONCEPT_CLASS_ID IN (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) AND INVALID_REASON IS NULL  AND STANDARD_CONCEPT = ?
order by CONCEPT_NAME ASC
