package org.ohdsi.webapi.check.checker.criteria;

import org.ohdsi.circe.cohortdefinition.Criteria;
import org.ohdsi.circe.cohortdefinition.DateRange;
import org.ohdsi.circe.cohortdefinition.NumericRange;
import org.ohdsi.circe.cohortdefinition.VisitDetail;
import org.ohdsi.webapi.check.builder.DateRangeValidatorBuilder;
import org.ohdsi.webapi.check.builder.NumericRangeValidatorBuilder;
import org.ohdsi.webapi.check.builder.ValidatorGroupBuilder;

public class VisitDetailHelper {
    public static ValidatorGroupBuilder<Criteria, VisitDetail> prepareVisitDetailBuilder() {
        ValidatorGroupBuilder<Criteria, VisitDetail> builder =
                new ValidatorGroupBuilder<Criteria, VisitDetail>()
                        .attrName("VisitDetail")
                        .conditionGetter(t -> t instanceof VisitDetail)
                        .valueGetter(t -> (VisitDetail) t)
                        .groups(
                                prepareAgeBuilder(),
                                prepareStartDateBuilder(),
                                prepareEndDateBuilder(),
                                prepareVisitDetailLengthBuilder()
                        );
        return builder;
    }

    private static ValidatorGroupBuilder<VisitDetail, NumericRange> prepareAgeBuilder() {
        ValidatorGroupBuilder<VisitDetail, NumericRange> builder =
                new ValidatorGroupBuilder<VisitDetail, NumericRange>()
                        .attrName("age")
                        .valueGetter(t -> t.age)
                        .validators(
                                new NumericRangeValidatorBuilder<>()
                        );
        return builder;
    }

    private static ValidatorGroupBuilder<VisitDetail, DateRange> prepareStartDateBuilder() {
        ValidatorGroupBuilder<VisitDetail, DateRange> builder =
                new ValidatorGroupBuilder<VisitDetail, DateRange>()
                        .attrName("occurrence start date")
                        .valueGetter(t -> t.occurrenceStartDate)
                        .validators(
                                new DateRangeValidatorBuilder<>()
                        );
        return builder;
    }

    private static ValidatorGroupBuilder<VisitDetail, DateRange> prepareEndDateBuilder() {
        ValidatorGroupBuilder<VisitDetail, DateRange> builder =
                new ValidatorGroupBuilder<VisitDetail, DateRange>()
                        .attrName("occurrence end date")
                        .valueGetter(t -> t.occurrenceEndDate)
                        .validators(
                                new DateRangeValidatorBuilder<>()
                        );
        return builder;
    }

    private static ValidatorGroupBuilder<VisitDetail, NumericRange> prepareVisitDetailLengthBuilder() {
        ValidatorGroupBuilder<VisitDetail, NumericRange> builder =
                new ValidatorGroupBuilder<VisitDetail, NumericRange>()
                        .attrName("visit detail length")
                        .valueGetter(t -> t.visitLength)
                        .validators(
                                new NumericRangeValidatorBuilder<>()
                        );
        return builder;
    }
}
