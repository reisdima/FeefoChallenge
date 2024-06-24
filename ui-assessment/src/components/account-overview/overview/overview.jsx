import styled from "styled-components"

export const Overview = ({ data }) => {

    const Sale = styled.div`
        display: grid;
        grid-template-columns: 1fr 1fr;
        grid-template-rows: auto auto;
        width: 100%;
        grid-template-columns: auto auto;
    `

    const InfoBox = styled.div`
        background-color: white;
        grid-column: ${props => props.gridColumn};
        padding: 1em;
        margin: 2px;
    `

    const Summary = styled.div`
        width: 100%;
        display: flex;
        height: 6em;
        flex-direction: column;
        justify-content: space-around;
        align-items: flex-start;
    `

    const PercentageInfo = styled.div`
        width: 100%;
        display: flex;
        flex-direction: column;
        align-items: flex-start;
    `

    const Percentage = styled.span`
        color: #56c756;
        font-weight: bold;
        font-size: 3em;
    `

    const DataName = styled.span`
        font-size: 1em;
        font-weight: 600;
        color: gray;
    `

    const uploadPercentage = (data?.successfulUploads / data?.uploads) * 100;
    const linesSavedPercentage = (data?.linesSaved / data?.linesAttempted) * 100;

  
    return (
        <Sale>
            <InfoBox gridColumn="span 2">
                <Summary>
                    <div><span style={{fontSize: "1.2em", fontWeight: "bold"}}>Sales</span></div>
                    <div>You had <span style={{fontWeight: "bold"}}>{data?.uploads} uploads</span> and <span style={{fontWeight: "bold"}}>0 lines added</span>.</div>
                </Summary>
            </InfoBox>
            <InfoBox>
                <PercentageInfo>
                    <Percentage>{uploadPercentage}%</Percentage>
                    <DataName>UPLOAD SUCCESS</DataName>
                </PercentageInfo>
            </InfoBox>
            <InfoBox>
                <PercentageInfo>
                    <Percentage>{linesSavedPercentage}%</Percentage>
                    <DataName>LINES SAVED</DataName>
                </PercentageInfo>
            </InfoBox>

        </Sale>
    )
  }